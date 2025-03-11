class GestionProductos {
    private val listaProductos = mutableListOf<Producto>()

    fun crearProducto(codigo: Int, nombre: String, precio: Int, stock: Int): Producto{
        if (listaProductos.any { it.codigoProducto == codigo }){
            throw IllegalArgumentException("Ya existe un producto con el codigo $codigo")                                           //throw se usa para lanzar errores o excepciones en Kotlin
        }                                                                                                                           //IllegalArgumentException es un tipo de excepción que indica que se pasó un argumento inválido a la función.
        val nuevoProducto = Producto(codigo, nombre, precio, stock)
        listaProductos.add(nuevoProducto)
        return nuevoProducto
    }
    fun eliminarProducto(codigo: Int): Boolean{
        val producto = listaProductos.find { it.codigoProducto == codigo }
        return if (producto != null){
            listaProductos.remove(producto)
            true
        } else {
            false
        }
    }
    fun buscarProducto (codigo: Int): Producto?{
        return listaProductos.find { it.codigoProducto == codigo }
    }
    fun mostrarTodoslosProductos(){
        if(listaProductos.isEmpty()){
            println("No hay productos disponibles")
            return
        }
        println("LISTA DE PRODUCTOS ")
        listaProductos.forEach { Producto -> listaProductos.mostrarInformacion() }
        println("-------")
    }
    fun mostrarTotalinventario(){
        val totalInventario = listaProductos.sumOf { it.calcularValorInventario() }
        println("El valor total del inventario es: $$totalInventario")
    }






}