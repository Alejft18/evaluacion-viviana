
//Listar Productos
$(document).ready(function(){

    $('#listar').on('click', function(){
        let tabla= document.querySelector('#tabla')
        tabla.innerHTML=''
        tabla.innerHTML=' <thead><tr><td>Codigo</td><td>Nombre</td><td>Categoria</td><td>Precio</td><td>Cantidad</td><td>Descuento</td><td>Total</td></tr></thead>'

        $.ajax({
            url: "http://localhost:8080/listarProductos",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta);
                for (let i = 0;  i <= respuesta.length;  i++) {
                    tabla.innerHTML+='<tr><td>'+ 
                    respuesta[i].codigo+'</td><td>'+
                    respuesta[i].nombre+ '</td><td>'+
                    respuesta[i].categoria+ '</td><td>'+
                    respuesta[i].precio+ '</td><td>'+
                    respuesta[i].cantidad+ '</td><td>'+
                    respuesta[i].descuento+ '</td><td>'+
                    respuesta[i].total+ '</td><tr>'
                }
            }
        });
    });



    //Actualizar precio producto

    $('#actualizar').on('click', function(){
        let datos={
            codigo: parseInt($('#id').val()),
            precio: parseInt($('#precio').val())
        }
        console.log(datos);

        let datosEnvio=JSON.stringify(datos);
        $.ajax({
            type: "POST",
            url:"http://localhost:8080/actualizarPrecio",
            
            data: {
                codigo: parseInt($('#id').val()),
                precio: parseInt($('#precio').val())
            }

        });

    });


    //total de todos los productos

    $('#totalProductos').on('click', function(){
        $.ajax({
            type:"GET", 
            url: "http://localhost:8080/total",
            success:function(respuesta){
                console.log(respuesta)
                $('#total').append("El precio de toda la lista es de: $"+respuesta.toLocaleString()+" IVA incluido")
            }

        });

    });


    //Total por producto
    $('#totalPorProducto').on('click', function(){
        let tabla= document.querySelector('#tabla')
        tabla.innerHTML=''
        tabla.innerHTML=' <thead><tr><td>Codigo</td><td>Nombre</td><td>Categoria</td><td>Precio</td><td>Cantidad</td><td>Descuento</td><td>Total</td></tr></thead>'

        $.ajax({
            url: "http://localhost:8080/totalPorProducto",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta);
                for (let i = 0;  i <= respuesta.length;  i++) {
                    tabla.innerHTML+='<tr><td>'+ 
                    respuesta[i].codigo+'</td><td>'+
                    respuesta[i].nombre+ '</td><td>'+
                    respuesta[i].categoria+ '</td><td>'+
                    respuesta[i].precio+ '</td><td>'+
                    respuesta[i].cantidad+ '</td><td>'+
                    respuesta[i].descuento+ '</td><td>'+
                    respuesta[i].total+ '</td><tr>'
                }
            }
        });

    });



    //Descuento por categoria 
    $('#busCategoria').on('click', function(){
        let tabla= document.querySelector('#tabla')
        let categoria= $('#categoria').val();
        tabla.innerHTML=''
        tabla.innerHTML=' <thead><tr><td>Codigo</td><td>Nombre</td><td>Categoria</td><td>Precio</td><td>Cantidad</td><td>Descuento</td><td>Total</td></tr></thead>'
        $.ajax({
            url: "http://localhost:8080/descuentoCategoria/"+categoria,
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta);
                for (let i = 0;  i <= respuesta.length;  i++) {
                    tabla.innerHTML+='<tr><td>'+ 
                    respuesta[i].codigo+'</td><td>'+
                    respuesta[i].nombre+ '</td><td>'+
                    respuesta[i].categoria+ '</td><td>'+
                    respuesta[i].precio+ '</td><td>'+
                    respuesta[i].cantidad+ '</td><td>'+
                    respuesta[i].descuento+ '</td><td>'+
                    respuesta[i].total+ '</td><tr>'
                }
    
            }
        })
    });

    //actualizar precio por porcentaje
    $('#incremento').on('click', function(){
        let tablaIncre=document.querySelector('#tabla')
        tabla.innerHTML=''
        tabla.innerHTML=' <thead><tr><td>Codigo</td><td>Nombre</td><td>Categoria</td><td>Precio</td><td>Cantidad</td><td>Descuento</td><td>Total</td></tr></thead>'

        let datos={
            categoria: $('#categoriaIncre').val(),
            porcentaje: parseInt($('#porcentaje').val()),
            valor: $('#valor').val()
        }
        console.log(datos);

        let datosEnvio=JSON.stringify(datos);
        $.ajax({
            type: "POST",
            url:"http://localhost:8080/actualizarPrecioPorcentaje",
            
            data: {
                categoria: $('#categoriaIncre').val(),
                porcentaje: parseInt($('#porcentaje').val()),
                valor: $('#valor').val()
            },
            success:function(respuesta){
                console.log(respuesta)
                for (let i = 0;  i <= respuesta.length;  i++) {
                    tabla.innerHTML+='<tr><td>'+ 
                    respuesta[i].codigo+'</td><td>'+
                    respuesta[i].nombre+ '</td><td>'+
                    respuesta[i].categoria+ '</td><td>'+
                    respuesta[i].precio+ '</td><td>'+
                    respuesta[i].cantidad+ '</td><td>'+
                    respuesta[i].descuento+ '</td><td>'+
                    respuesta[i].total+ '</td><tr>'
                }
            }

        });

    });

    


});


