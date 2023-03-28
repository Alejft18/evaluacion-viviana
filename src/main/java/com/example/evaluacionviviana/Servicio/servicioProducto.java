package com.example.evaluacionviviana.Servicio;

import com.example.evaluacionviviana.Modelo.Producto;

import java.util.ArrayList;

public class servicioProducto {


    public ArrayList<Producto> lista=new ArrayList<>();


    public servicioProducto(){
        lista.add(new Producto(1,"Mango","Frutas",5000,2,0,0));
        lista.add(new Producto(2,"Arroz","Dispensa",2400,5,0,0));
        lista.add(new Producto(3,"Banano","Frutas",2000,1,0,0));
        lista.add(new Producto(4,"Frijol","Dispensa",4000,1,0,0));
        lista.add(new Producto(5,"Tomate","Verduras",800,3,0,0));
        lista.add(new Producto(6,"Cebolla","Frutas",1000,2,0,0));
        lista.add(new Producto(7,"Lentaja","Dispensa",4200,2,0,0));
        lista.add(new Producto(8,"Pollo","Carnicos",20000,1,0,0));
        lista.add(new Producto(9,"Panela","Dispensa",3000,3,0,0));
        lista.add(new Producto(10,"Huevos","Carnicos",15000,2,0,0));

    }

    public ArrayList<Producto> listar() {
        return lista;
    }

    public String actualizarPrecio(Producto p){
        String mensaje="";
        for (Producto pro : lista){
            if (p.getCodigo()==pro.getCodigo()){
                pro.setPrecio(p.getPrecio());
                mensaje="Actualizacion exitosa";

            }else {
                mensaje="No se actualizó";
            }
        }
        return mensaje;
    }


    public ArrayList<Producto>totalPorProducto(){
        double total=0;
        double descuento=0;
        for (int i=0; i<lista.size();i++){
            descuento=lista.get(i).getPrecio() * lista.get(i).getCantidad();
            total=(descuento-8)/100;
            lista.get(i).setTotal(descuento);
            lista.get(i).setDescuento(total);


            lista.set(i,lista.get(i));
        }
        return lista;

    }




    public double total(){
        double total=0;
        double x=0;

        for (int i=0; i<lista.size();i++){
            total= lista.get(i).getPrecio() * lista.get(i).getCantidad();
            lista.get(i).setTotal(total);
            lista.set(i,lista.get(i));
            x += total;
        }
        return x + ((x*19)/100) - (x*8/100);

    }

}
