const express = require("express");
const router = express.Router();
const { createClient } = require("./controllers/clientController");

router.post("/clientes", createClient);

module.exports = router;
