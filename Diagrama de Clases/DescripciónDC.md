# Descripción para el diagrama de clases propuesto
El diagrama de clases representa el modelo orientado a objetos de una aplicación tipo e-commerce similar a Mercado Libre, donde intervienen usuarios, publicaciones, pedidos y pagos.


#### **Descripción general:**

-----
- Usuario es la clase base de la que heredan Cliente, Vendedor y Administrador, cada uno con responsabilidades específicas.

- Cliente puede registrarse, administrar su Carrito, realizar Pedidos y dejar Reseñas.

- Vendedor gestiona sus Publicaciones (crear, pausar, modificar, etc.) y administra el stock de Productos.

- Administrador controla usuarios y genera reportes.

- Producto representa los artículos que se comercializan, asociados a un TipoCategoría.
- Los productos se publican mediante la clase Publicación, la cual tiene estados (borrador, activo, etc.) y pertenece a un vendedor.

- Pedido agrupa uno o más DetallePedido (productos comprados con sus cantidades y precios).
Está ligado a un Cliente, y se relaciona con el Pago, Factura, Envío y Dirección correspondientes.
Los estados del pedido, envío y pago se controlan con enumeraciones específicas.

- Carrito permite al cliente agregar o quitar productos antes de confirmar un pedido.

- Pago y Factura gestionan la transacción económica y el comprobante, mientras que Envío y Dirección administran la entrega física.
