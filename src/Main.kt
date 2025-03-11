fun main() {
    val gestion = GestionProductos()
    var opcion = Int = -1


    while (opcion != 0) {
        println("SISTEMA DE GESTIO DE PRODUCTOS")
        println("1. Crear Producto ")
        println("2. Vender Producto")
        println("3. Reponer Stock")
        println("4. Aplicar Descuento (2%)")
        println("5. Mostrar informacion de un prodcuto")
        println("6. Aumentar el precio (6%)")
        println("7. Mostrar el valor total del inventario")

        try{
            opcion = readLine()?.toIntOrNull() ?: -1


            when (opcion){
                1 -> {
                    println("Ingrese el codigo del producto: ")
                    val codigo = readLine() ?: ""
                    println("Ingrese el nombre del producto: ")
                    val nombre = readLine() ?: ""
                    println("Ingrese el precio del producto: ")
                    val precio = readLine().toIntOrNull() ?: 0
                    println("Ingrese la cantidad en stock")
                    val cantidad = readLine().toIntOrNull() ?: 0

                    try {
                        val producto = gestion.crearProducto(codigo, nombre, precio, cantidad)
                        println("Producto creado exitosamente")
                        producto.mostrarInformacion()
                    } catch (e: IllegalArgumentException){
                        println("Error ")
                    }
                }
                2 -> {
                    println("Ingrese el producto del codigo a vender ")
                    val codigo = readLine() ?: ""
                    println("Ingrese cantidad a vender: ")
                    val cantidad = readLine().toIntOrNull() ?: 0
                    val producto = gestion.buscarProducto(codigo)
                    if(producto != null ){
                        if (producto.vender(cantidad)){
                            println("Producto vendido con exito")
                        } else{
                            println("No se pudo vender el producto")
                        }
                    }

                }
            }
        }



    }

}