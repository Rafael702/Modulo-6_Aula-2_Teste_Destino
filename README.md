# Destino Zup 

-----

Requisições: 

### POST /destinos
````json
{
      "nome":"Long Beach",
      "regiao":{
           "nome":"Sudeste"
      },
      "categorias":[
            {
                  "nome":"Praia"
            }
      ]
}

````

#### Response
- Status 201
````json
{
      "id": 1,
      "nome": "Long Beach",
      "regiao": {
            "nome": "Sudeste"
      },
      "categorias": [
            {
                  "nome": "Praia"
            }
      ]
}
````