const mongoose = require('mongoose');
const Caminhao = mongoose.model('Caminhao');

exports.getCaminhao = async () => {
    const result = await Caminhao.find({}, 'marca valor modelo _id ano');
    return result;
}

exports.getById = async (id) =>{
    const result = await Caminhao.findOne({_id : id},"_id marca modelo valor ano")
    return result;
}

exports.put = async (id,data) => {
    await Caminhao.findByIdAndUpdate(id, {
        $set:{
            marca: data.marca,
            modelo: data.modelo,
            ano: data.ano,
            valor: data.valor
        }
    })
}

exports.create = async (data) => {
    let caminhao = Caminhao(data)
    await caminhao.save();
}

exports.delete = async (id) => {
    await Caminhao.findByIdAndDelete(id)
}