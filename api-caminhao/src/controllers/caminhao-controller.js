const http = require('http');
const repository = require('../repositories/caminhao-repository')

exports.get = async(req, res, next)=> {
    const data = await repository.getCaminhao();
    res.status(200).send(data);
}

exports.post = async(req, res, next) => {
    var options = {
        host: 'localhost',
        port: 8080,
        path: '/send-email',
        method: 'POST',
        headers: {
             'Content-Type': 'application/json'
           }
      };

    try{
        await repository.create(req.body);

        http.request(options, function (response) {
            console.log('Status:', response.statusCode);
        })

        res.status(201).send({message: "Caminhao cadastrado com sucesso!"})
    }catch(erro){
        res.status(400).send({message: "erro ao cadastrar caminhao"});
    }
}

exports.put = async(req, res, next)=>{
    const id = req.params.id;
    const body = req.body;

    await repository.put(id, body);
    res.status(200).send({message: "Caminhao atualizado com sucesso"});
}

exports.getById = async(req, res, next) => {
    const id = req.params.id;
    const data = await repository.getById(id);
    if(data == null){
        res.status(404).send();
   }
   res.status(200).send(data)
}

exports.delete = async(req, res, next)=>{
    const id = req.params.id;

    await repository.delete(id);
    res.status(200).send({message: "Caminhao removido com sucesso"})
}