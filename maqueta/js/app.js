$(document).ready(function(){
    $('#lista-servicio').hide();
    $('#buscar').on('submit', function(e){
        e.preventDefault();
        $('#listado-servicios').hide();
        $('#lista-servicio').show();
        $('#datetimepicker').datetimepicker({
            defaultDate: "11/1/2013",
            disabledDates: [
                moment("12/25/2013"),
                new Date(2013, 11 - 1, 21),
                "11/22/2013 00:53"
            ]
        });
    });
});
