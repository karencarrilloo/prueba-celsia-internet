const express = require('express');
const axios = require('axios');
const bodyParser = require('body-parser');

const app = express();

app.set('view engine', 'ejs');
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));

const apiBaseUrlClients = 'http://localhost:8080/celsia-test/api/clients';
const apiBaseUrlServices = 'http://localhost:8080/celsia-test/api/services';

// Route to list all clients
app.get('/', async (req, res) => {
    try {
        const response = await axios.get(`${apiBaseUrlClients}/getAllClients`);
        res.render('index', { clients: response.data });
    } catch (error) {
        res.status(500).send('Error al obtener los clientes');
    }
});

// Route to display the create client form
app.get('/create', (req, res) => {
    res.render('create');
});

// Route to save a new client
app.post('/create', async (req, res) => {
    try {

        const responseAll = await axios.get(`${apiBaseUrlClients}/getAllClients`);
        const data = responseAll.data;
        const idToValidate = req.body.identification;
        let exists = false;

        for (let i = 0; i < data.length; i++) {
            if (data[i].identification === idToValidate) {
              exists = true;
              break;
            }
        }

        if (exists) {
            res.status(500).send('Cliente ya existe');
        } else {
            const inputDate = req.body.birthDate;
            const isoDate = new Date(inputDate).toISOString();
            await axios.post(`${apiBaseUrlClients}/saveClient`, {
                identification: req.body.identification,
                identificationType: req.body.identificationType,
                name: req.body.name,
                lastName: req.body.lastName,
                birthDate: isoDate,
                cellphone: req.body.cellphone,
                email: req.body.email
            });
            res.redirect('/');
        }
    } catch (error) {
        res.status(500).send('Error al guardar el cliente');
    }
});

// Route to display the edit client form
app.get('/edit/:identification', async (req, res) => {
    try {
        const response = await axios.get(`${apiBaseUrlClients}/getClientById`, {
            data: req.params.identification
        });
        res.render('edit', { client: response.data });
    } catch (error) {
        res.status(500).send('Error al obtener la informacion del cliente');
    }
});

// Route to update a client
app.post('/edit/:identification', async (req, res) => {
    try {
        await axios.post(`${apiBaseUrlClients}/saveClient`, {
            identification: req.body.identification,
            identificationType: req.body.identificationType,
            name: req.body.name,
            lastName: req.body.lastName,
            birthDate: req.body.birthDate,
            cellphone: req.body.cellphone,
            email: req.body.email
        });
        res.redirect('/');
    } catch (error) {
        res.status(500).send('Error al actualizar el cliente');
    }
});

// Route to delete a client
app.post('/delete/:id', async (req, res) => {
    try {
        await axios.delete(`${apiBaseUrlClients}/deleteClient`, {
            data: req.params.id
        });
        res.redirect('/');
    } catch (error) {
        res.status(500).send('Error al eliminar el cliente, el cliente cuenta con servicios');
    }
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});

// Route to list all services
app.get('/services/:identification', async (req, res) => {
    try {
        const response = await axios.get(`${apiBaseUrlServices}/getAllServices`);

        const data = response.data;
        const idClient = req.params.identification;
        let finalResponse = [];

        for (let i = 0; i < data.length; i++) {
            if (data[i].identification === idClient) {
                finalResponse.push(data[i]);
            }
        }
        res.render('services', { services: finalResponse, idClient: idClient });
    } catch (error) {
        res.status(500).send('Error al obtener los servicios');
    }
});


// Route to display the create service form
app.get('/createService/:identification', (req, res) => {
    const identification = req.params.identification;
    res.render('createService', { identification: identification });
});

// Route to save a new service
app.post('/createService/:identification', async (req, res) => {
    try {
        const id = req.body.identification;
        const startDate = req.body.startDate;
        const isostartDate = new Date(startDate).toISOString();

        const lastBilling = req.body.lastBilling;
        const isolastBilling = new Date(lastBilling).toISOString();

        await axios.post(`${apiBaseUrlServices}/saveService`, {
            identification: req.body.identification,
            service: req.body.service,
            startDate: isostartDate,
            lastBilling: isolastBilling,
            lastPay: req.body.lastPay,
            client: {
                "identification": req.body.identification,
                "name": "string",
                "lastName": "string",
                "identificationType": "string",
                "birthDate": "2024-09-19T02:54:08.567Z",
                "cellphone": "string",
                "email": "string"
              }
        });
        res.redirect('/services/' + id);
    } catch (error) {
        res.status(500).send('Error al guardar el servicio');
    }
});

// Route to delete a service
app.post('/deleteService/:identification', async (req, res) => {
    try {
        let id = req.params.identification;
        await axios.delete(`${apiBaseUrlServices}/deleteService`, {
            data: req.params.identification
        });
        res.redirect('/services/' + id);
    } catch (error) {
        res.status(500).send('Error al eliminar el servicio');
    }
});