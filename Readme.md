# Modulo 14 - Aula 3 - consultorio

### Repositório da solução do exercicio da aula 3

A fim de facillitar a execução da aplicação do exercicio tomei a liberdade de criar apenas um endpoint aonde a base de dados é inicializada com os dados necessarios e prontos:


#### Inicialização do banco de dados

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/post</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    ok

</pre>

#### Ex 1. Listar todos os pacientes atendidos, em um dia, por todos os dentistas.

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/patients?date=YYYY-MM-DD</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "name": "Joao",
            "last_name": "Ghordo",
            "address": "Pirapitingui - SP",
            "dni": "oshee",
            "birth_date": "1994-08-05",
            "phone": "+551598857431",
            "email": "jao.gordasso@gmail.com",
            "turns": [
                {
                    "day": "2021-08-10",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Joao Ghordo",
                    "turnStatus": "Pendente",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-08-24",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Joao Ghordo",
                    "turnStatus": "Pendente",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-06-22",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Joao Ghordo",
                    "turnStatus": "Concluído",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-07-24",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Joao Ghordo",
                    "turnStatus": "Pendente",
                    "reprogramedTurn": null
                }
            ]
        },
        {
            "name": "Giulia",
            "last_name": "Franco",
            "address": "Rio Branco - AC",
            "dni": "oshee",
            "birth_date": "1992-07-14",
            "phone": "+55739857431",
            "email": "giu_diva@terra.com",
            "turns": [
                {
                    "day": "2021-09-24",
                    "dentist": "Celso Rodriguez",
                    "patient": "Giulia Franco",
                    "turnStatus": "Pendente",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-08-24",
                    "dentist": "Celso Rodriguez",
                    "patient": "Giulia Franco",
                    "turnStatus": "Pendente",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-07-22",
                    "dentist": "Celso Rodriguez",
                    "patient": "Giulia Franco",
                    "turnStatus": "Concluído",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-07-24",
                    "dentist": "Celso Rodriguez",
                    "patient": "Giulia Franco",
                    "turnStatus": "Pendente",
                    "reprogramedTurn": null
                }
            ]
        }
    ]

</pre>
<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>date (Endpoint)</td><td>String</td><td>Data desejada para a consulta no formato YYYY-MM-DD (no exemplo acima foi usado o dia 2021-07-24)</td></tr>
</table>
</pre>

#### Ex 2. Listar todos os dentistas que tenham mais de dois turnos em uma data

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/dentist/day</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "name": "Celso",
            "last_name": "Rodriguez",
            "address": "São Caetano do Sul",
            "dni": "oshee",
            "birth_date": "1992-08-05",
            "phone": "+551696887421",
            "email": "celso.coringao@hotmail.com",
            "code_mp": "B123456b",
            "diarys": [
                {
                "start_time": "2021-07-24T16:30:00",
                "ending_time": "2021-07-24T17:00:00",
                "turns": [
                        {
                            "day": "2021-09-01",
                            "dentist": "Celso Rodriguez",
                            "patient": "Felipe Farias",
                            "turnStatus": "Pendente",
                            "reprogramedTurn": null
                        },
                        {
                            "day": "2021-03-22",
                            "dentist": "Celso Rodriguez",
                            "patient": "Felipe Farias",
                            "turnStatus": "Concluído",
                            "reprogramedTurn": null
                        },
                        {
                            "day": "2021-04-10",
                            "dentist": "Celso Rodriguez",
                            "patient": "Felipe Farias",
                            "turnStatus": "Concluído",
                            "reprogramedTurn": null
                        },
                        {
                            "day": "2021-07-24",
                            "dentist": "Celso Rodriguez",
                            "patient": "Felipe Farias",
                            "turnStatus": "Pendente",
                            "reprogramedTurn": null
                        },
                        {
                            "day": "2021-07-24",
                            "dentist": "Celso Rodriguez",
                            "patient": "Giulia Franco",
                            "turnStatus": "Pendente",
                            "reprogramedTurn": null
                        },
                        {
                            "day": "2021-07-24",
                            "dentist": "Celso Rodriguez",
                            "patient": "Giulia Franco",
                            "turnStatus": "Concluído",
                            "reprogramedTurn": null
                        },
                        {
                            "day": "2021-08-24",
                            "dentist": "Celso Rodriguez",
                            "patient": "Giulia Franco",
                            "turnStatus": "Pendente",
                            "reprogramedTurn": null
                        },
                        {
                            "day": "2021-09-24",
                            "dentist": "Celso Rodriguez",
                            "patient": "Giulia Franco",
                            "turnStatus": "Pendente",
                            "reprogramedTurn": null
                        }
                    ]
                }
            ]
        }
    ]

</pre>
<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>date (Endpoint)</td><td>String</td><td>Data desejada para a consulta no formato YYYY-MM-DD (no exemplo acima foi usado o dia 2021-07-24)</td></tr>
</table>
</pre>

#### Ex 3. Listar todos os turnos com status finalizado
<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/turns/finalized</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "day": "2021-06-22",
            "dentist": "Francisco Tiradentes",
            "patient": "Joao Ghordo",
            "turnStatus": "Concluído",
            "reprogramedTurn": null
        },
        {
            "day": "2021-03-22",
            "dentist": "Celso Rodriguez",
            "patient": "Felipe Farias",
            "turnStatus": "Concluído",
            "reprogramedTurn": null
        },
        {
            "day": "2021-04-10",
            "dentist": "Celso Rodriguez",
            "patient": "Felipe Farias",
            "turnStatus": "Concluído",
            "reprogramedTurn": null
        },
        {
            "day": "2021-01-10",
            "dentist": "Francisco Tiradentes",
            "patient": "Beatriz Knusty",
            "turnStatus": "Concluído",
            "reprogramedTurn": null
        },
        {
            "day": "2021-02-05",
            "dentist": "Francisco Tiradentes",
            "patient": "Beatriz Knusty",
            "turnStatus": "Concluído",
            "reprogramedTurn": null
        },
        {
            "day": "2021-05-02",
            "dentist": "Francisco Tiradentes",
            "patient": "Beatriz Knusty",
            "turnStatus": "Concluído",
            "reprogramedTurn": null
        },
        {
            "day": "2021-07-15",
            "dentist": "Francisco Tiradentes",
            "patient": "Beatriz Knusty",
            "turnStatus": "Concluído",
            "reprogramedTurn": null
        },
        {
            "day": "2021-07-24",
            "dentist": "Celso Rodriguez",
            "patient": "Giulia Franco",
            "turnStatus": "Concluído",
            "reprogramedTurn": null
        }
    ]

</pre>

#### Ex 4. Listar todos os turnos com estado pendente de um dia

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/turns/pendent</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "day": "2021-07-24",
            "dentist": "Francisco Tiradentes",
            "patient": "Joao Ghordo",
            "turnStatus": "Pendente",
            "reprogramedTurn": null
        },
        {
            "day": "2021-07-24",
            "dentist": "Celso Rodriguez",
            "patient": "Felipe Farias",
            "turnStatus": "Pendente",
            "reprogramedTurn": null
        },
        {
            "day": "2021-07-24",
            "dentist": "Celso Rodriguez",
            "patient": "Giulia Franco",
            "turnStatus": "Pendente",
            "reprogramedTurn": null
        }
    ]

</pre>

#### Ex 5. Listar a agenda de um dentista

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/post</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "start_time": "2021-07-24T15:30:00",
            "ending_time": "2021-07-24T16:00:00",
            "turns": [
                {
                    "day": "2021-07-24",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Joao Ghordo",
                    "turnStatus": "Pendente",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-06-22",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Joao Ghordo",
                    "turnStatus": "Concluído",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-08-24",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Joao Ghordo",
                    "turnStatus": "Pendente",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-08-10",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Joao Ghordo",
                    "turnStatus": "Pendente",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-01-10",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Beatriz Knusty",
                    "turnStatus": "Concluído",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-02-05",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Beatriz Knusty",
                    "turnStatus": "Concluído",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-05-02",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Beatriz Knusty",
                    "turnStatus": "Concluído",
                    "reprogramedTurn": null
                },
                {
                    "day": "2021-07-15",
                    "dentist": "Francisco Tiradentes",
                    "patient": "Beatriz Knusty",
                    "turnStatus": "Concluído",
                    "reprogramedTurn": null
                }
            ]
        }
    ]

</pre>

#### Ex 6. Listar todos os turnos que foram remarcados de um dentista

Para listar os reprogramados, antes é necessario reprogramar uma consulta, para isto foi disponibliizado o endpoint a seguir:

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/turns/reprogram/{idPatient}/{idTurn}</code><br><code>Exemplo: http://localhost:8080/turns/reprogram/4/16</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    ok

</pre>

Então para consulta do exercício utilizamos o endpoint a seguir:

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/turns/reprogrammed/{idDentist}</code><br><code>Exemplo: http://localhost:8080/turns/reprogrammed/2</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "day": "2021-07-27",
            "dentist": "Celso Rodriguez",
            "patient": "Giulia Franco",
            "turnStatus": "Pendente",
            "reprogramedTurn": {
                "day": "2021-09-24",
                "dentist": "Celso Rodriguez",
                "patient": "Giulia Franco",
                "turnStatus": "Cancelado",
                "reprogramedTurn": null
            }
        }
    ]

</pre>

#### Ex 7. Listar todos os turnos que foram remarcados. (extra)

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/turns/reprogrammed</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "day": "2021-07-27",
            "dentist": "Celso Rodriguez",
            "patient": "Giulia Franco",
            "turnStatus": "Pendente",
            "reprogramedTurn": {
                "day": "2021-09-24",
                "dentist": "Celso Rodriguez",
                "patient": "Giulia Franco",
                "turnStatus": "Cancelado",
                "reprogramedTurn": null
            }
        }
    ]

</pre>