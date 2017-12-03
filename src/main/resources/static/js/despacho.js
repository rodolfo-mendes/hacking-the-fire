$(function(){
    var map = new GMaps({
      el: '#mapa',
      lat: -18.9186100,
      lng: -48.2772200
    });

    map.setZoom(12);

    this.mostrarNoMapa = function(source){
        map.removeMarkers();

        var id = $(source).attr('data-id');
        var tipoOcorrencia = $(source).attr('data-tipo');

        $.get('http://localhost:8080/api/ocorrencias/' + id + '/coordenadas',
            function(data){
                console.log(data);

                var infoContent =
                    "<div class='box notification is-danger'>" +
                        "<h2>" + data['ocorrencia']['nomePaciente'] + "</h2>" +
                        data['ocorrencia']['sexo'] + ", " + data['ocorrencia']['idade'] + " anos"
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
                    map.addMarker({
                        icon: '/img/ambulance.png',
                        lat: data[i]['latitude'],
                        lng: data[i]['longitude']
                    });
                }
            }
        );
    }
});