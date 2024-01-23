# PRUEBA TECNICA BACKEND TITA MEDIA

### Configuración
Asegúrate de tener las siguientes herramientas instaladas en tu entorno de desarrollo:
* Java 17
* SringBoot 3.2.0
* Base de datos MYSQL
#### NOTA
Una vez se replique el proyecto, se deberá crear la base de datos llamada payment_bank, posteriormente ejecutar los scripts en los cuales se encuentran la creación de la base de datos, y la inserción de datos base.
####  La aplicación se ejecutará en http://localhost:8030 por defecto.
Los siguientes Endpoints a ejecutar son:

#### - Bancos asociados a un usuario.
```bash
  curl --location --request GET 'http://localhost:8030/customer/getBanksForUser?dni=11223344'
  ```
#### - Deudas por usuario y por banco.
```bash
curl --location --request GET'http://localhost:8030/loan/getListLoansToBank?dni=11223344&bankId=3'
  ```
#### - Detalle de la deuda.
```bash
  curl --location --request GET 'http://localhost:8030/loan/getDetailsLoan?loanId=3'
  ```
#### - Pago de deudas.
```bash
  curl --location --request POST 'http://localhost:8030/payment/process'
  ```
#### - Para el pago de deudas se envía un body formato JSON de la siguiente manera.
```bash
{
    "loanId":"3",
    "amount":"10000000",
    "quotaQuantity": "10"
}
  ```

### Estructura del Proyecto
#### 1. Listado de Bancos
   La aplicación proporciona una interfaz intuitiva que permite al usuario visualizar todos los bancos con los que tiene deudas pendientes. Esta funcionalidad permite al usuario obtener una visión general de sus obligaciones financieras.

#### 2. Listado de Deudas por Banco
   Una vez que el usuario selecciona un banco, la aplicación presenta una lista detallada de las deudas asociadas con ese banco específico. Esto incluye información sobre cuánto ha pagado el usuario, cuántas cuotas debe y el monto total pendiente.

#### 3. Detalles de Deuda
   El sistema permite al usuario profundizar en los detalles de una deuda seleccionada, mostrando información detallada como los pagos realizados, cuotas restantes y el saldo total pendiente.

#### 4. Proceso de Pago
   La aplicación facilita al usuario el proceso de pago, brindando la opción de seleccionar el número de cuotas a pagar o saldar la deuda en su totalidad. Después del pago, la aplicación actualiza automáticamente la información para reflejar el nuevo estado de la deuda, incluyendo el saldo restante y las cuotas pendientes.