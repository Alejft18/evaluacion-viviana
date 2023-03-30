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
        lista.add(new Producto(6,"Cebolla","Verduras",1000,2,0,0));
        lista.add(new Producto(7,"Lentaja","Dispensa",4200,2,0,0));
        lista.add(new Producto(8,"Pollo","Carnicos",20000,1,0,0));
        lista.add(new Producto(9,"Panela","Dispensa",3000,3,0,0));
        lista.add(new Producto(10,"Huevos","Carnicos",15000,2,0,0));

    }

    public ArrayList<Producto> listar() {
        return lista;
    }

    public ArrayList<Producto> actualizarPrecio(int codigo, int precio) {
        for (Producto pro : lista) {
            if (pro.getCodigo() == codigo) {
                pro.setPrecio(precio);
            }
        }
        return lista;
    }


    public ArrayList<Producto>totalPorProducto(){
        double total=0;
        for (int i=0; i<lista.size();i++){
            total=lista.get(i).getPrecio() * lista.get(i).getCantidad();
            lista.get(i).setTotal(total);


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
        return x + ((x*19)/100);

    }

    public ArrayList<Producto>descuentoCategoria(String categoria){
        ArrayList<Producto>buscar=new ArrayList<>();
        double sub=0;
        double descuento=0;
        double total=0;
        int i=0;
        for (Producto producto:lista){
            if (producto.getCategoria().equals(categoria)){
                sub= lista.get(i).getPrecio() * lista.get(i).getCantidad();
                descuento= sub*8/100;
                total=sub-descuento;
                lista.get(i).setDescuento(descuento);
                lista.get(i).setTotal(total);
                lista.set(i,lista.get(i));
                buscar.add(producto);
            }
            i+=1;
        }
        return buscar;
    }

}
