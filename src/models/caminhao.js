'use strict'

const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const schema = new Schema({
    marca: {
        type: String,
        required: true,
        trim: true
    },
    modelo: {
        type: String,
        required: true,
        trim: true
    },
    ano: {
        type: Number,
        required: true
    },
    valor :{
        type: Number, 
        required:true
    },
});

module.exports = mongoose.model('Caminhao', schema);