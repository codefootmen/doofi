import { Content, Table, Button } from "../styles";
import { useSelector, useDispatch } from "react-redux";
import { Link } from "react-router-dom";
import Header from "../components/Header";
import { api } from "../services/api";

const transformRequest = (jsonData = {}) =>
  Object.entries(jsonData)
    .map((x) => `${encodeURIComponent(x[0])}=${encodeURIComponent(x[1])}`)
    .join("&");

function Bag() {
  const products = useSelector((state) => state.products);
  console.log(products);
  const remove = () => {};
  const send = () => {
    products.forEach((x) => {
      let order = {
        orderDescription: x.name,
        quantity: 1,
        client: {
          clientId: 1,
        },
        product: {
          productId: 1,
        },
      };

      api()
        .post(
          `/action/MakeOrderAction/`,
          transformRequest({
            value: JSON.stringify(order),
          }),
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        )
        .then((res) => {
          if (res.data) {
            window.location.reload();
          } else {
            alert("Transição inválida.");
          }
        });
    });
  };

  return (
    <>
      <Header />
      <Content>
        <Table>
          <tr>
            <th>Produto</th>
            <th>Restaurante</th>
          </tr>
          {products.map((x) => (
            <tr>
              <td>{x.name}</td>
              <td>{x.restaurantId}</td>
              <td>
                <Button>
                  <button onClick={remove.bind(this, x.id)}>Remover</button>
                </Button>
              </td>
            </tr>
          ))}
        </Table>
        <Button>
          <button onClick={send}>Enviar</button>
        </Button>
      </Content>
    </>
  );
}
export default Bag;
