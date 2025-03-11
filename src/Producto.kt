class Producto (
    val codigoProducto: Int,
    val nombreProducto: String,
    var precioProducto: Int,
    var cantidadEnStock: Int
){
    fun vender (cantidad: Int): Boolean{
        if (cantidadEnStock >= cantidad){
            cantidadEnStock -= cantidad
            return true
        }
        return false
    }
    fun reponerStock (cantidad: Int){
        cantidadEnStock += cantidad
    }
    fun aplicarDescuento() {
        var resultado = (precioProducto * 0.02).toInt()
        var descuento = precioProducto - resultado
    }
    fun mostrarInformacion(){
        println("Codigo del producto: $codigoProducto")
        println("Nombre del producto: $nombreProducto")
        println("Precio Del Producto: $$precioProducto")
        println("Cantidad en Stock: $cantidadEnStock")
        println("Valor total del inventario ${calcularValorInventario()} ")
    }
    fun aumentarPrecio(){
        var resultado = (precioProducto * 0.06).toInt()
        var aumentar = precioProducto + resultado
    }
    fun calcularValorInventario (): Int{
        return precioProducto * cantidadEnStock
    }

}