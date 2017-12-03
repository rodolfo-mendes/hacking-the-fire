$(function(){
    var map = new GMaps({
      el: '#mapa',
      lat: -18.9186100,
      lng: -48.2772200
    });

    map.setZoom(12);

    this.mostrarNoMapa = function(source){
        map.removeMarkers();

        var idOcorrencia = $(source).attr('data-id');
        var tipoOcorrencia = $(source).attr('data-tipo');

        $.get('http://localhost:8080/api/ocorrencias/' + idOcorrencia + '/coordenadas',
            function(data){
                console.log(data);

                var infoContent =
                    "<div class='box notification is-success'>" +
                        "<h2>" + data['ocorrencia']['nomePaciente'] + "</h2>" +
                        data['ocorrencia']['sexo'] + ", " + data['ocorrencia']['idade'] + " anos<br>" +
                        data['ocorrencia']['observacoes']
                    "</div>";

                map.addMarker({
                    icon: '/img/call.png',
                    lat: data['coordenadas']['latitude'],
                    lng: data['coordenadas']['longitude'],
                    infoWindow: {
                        content: infoContent
                    }
                });

                map.setCenter(data['coordenadas']['latitude'], data['coordenadas']['longitude']);
            });

        $.get(
            'http://localhost:8080/api/recursos/',
            {tipo: tipoOcorrencia, status: 'em-espera'},
            function(data){
                console.log(data);

                for(var i = 0 ; i < data.length ; i++){
                    var infoContent =
                        "<div class='box notification is-danger'>" +
                            "<h2>" + data[i]['descricao'] + "</h2>" +
                            "<button class='button is-danger is-inverted' " +
                                "onclick=\"despacharRecurso('" + idOcorrencia + "', '" + data[i]['id'] + "')\">" +
                                "Despachar" +
                            "</button>"
                        "</div>";

                    map.addMarker({
                        icon: '/img/ambulance.png',
                        lat: data[i]['latitude'],
                        lng: data[i]['longitude'],
                        infoWindow: {
                            content: infoContent
                        }
                    });
                }
            }
        );
    }

    this.despacharRecurso = function(idOcorrencia, idRecurso){
        $.post(
            'http://localhost:8080/api/atendimentos/',
            {ocorrencia: idOcorrencia, recurso: idRecurso},
            function(data){
                alert('O recurso ' + data['descricaoRecurso'] +
                    ' foi despachado para atender ' + data['nomePaciente']);
            }
        );
    }
});