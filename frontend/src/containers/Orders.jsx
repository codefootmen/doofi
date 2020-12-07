import { Content, Table, Button } from "../styles";
import { useSelector, useDispatch } from "react-redux";
import Header from "../components/Header";

function Orders() {
  //   const products = useSelector((state) => state.products);
  //   console.log(products);

  const order = [
    { name: "Toshio's Bake n Cake", restaurantId: 1, status: "CRIADO" },
    { name: "Toshio's Cook n Blunt ", restaurantId: 2, status: "ACEITO" },
    { name: "Toshio's Wiggle n Giggle", restaurantId: 3, status: "CANCELADO" },
    { name: "Toshio's Aunt Mary Cookies", restaurantId: 4, status: "COMPLETADO" },
    { name: "Toshio's Black Gold Chocolates", restaurantId: 1, status: "ENVIADO" },
    { name: "Toshio's Big Pillows Cotton Candy", restaurantId: 1, status: "CRIADO" },
  ];
  const actions = ["ACEITO", "CANCELADO", "CRIADO", "ENVIADO", "COMPLETADO"];

  const remove = () => {};
  return (
    <>
      <Header />
      <Content>
        <Table>
          <tr>
            <th>Produto</th>
            <th>Restaurante</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
          {order.map((x) => (
            <tr>
              <td>{x.name}</td>
              <td>{x.restaurantId}</td>
              <td>{x.status}</td>
              <td>
                <Button>
                  <button onClick={remove.bind(this, x.id)}>Aceitar</button>
                </Button>
              </td>
              <td>
                <Button>
                  <button onClick={remove.bind(this, x.id)}>Cancelar</button>
                </Button>
              </td>
              <td>
                <Button>
                  <button onClick={remove.bind(this, x.id)}>Enviar</button>
                </Button>
              </td>
              <td>
                <Button>
                  <button onClick={remove.bind(this, x.id)}>Completar</button>
                </Button>
              </td>
            </tr>
          ))}
        </Table>
      </Content>
    </>
  );
}
export default Orders;
