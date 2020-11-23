import { Content, Table, Button } from "../styles";
import { useSelector, useDispatch } from "react-redux";
import { Link } from "react-router-dom";
import Header from "../components/Header";

function Bag() {
  const products = useSelector((state) => state.products);
  console.log(products);
  const remove = () => {};

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
      </Content>
    </>
  );
}
export default Bag;
