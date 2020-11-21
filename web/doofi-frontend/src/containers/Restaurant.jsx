import { Content, Card, Button } from "../styles";
import { useEffect, useState } from "react";
import Header from "../components/Header";
import { addItem } from "../store/ducks/bag";
import { useDispatch } from "react-redux";

function Restaurant(props) {
  const [products, setProducts] = useState([]);
  const [restaurant, setRestaurant] = useState([]);
  const dispatch = useDispatch();

  const { id } = props.match.params;

  useEffect(() => {
    //Fetch content here
    setRestaurant({ name: "Generico", type: "Pizzaria" });
    setProducts([
      { id: 1, name: "Produto Genérico", restaurantId: 1 },
      { id: 2, name: "Produto Genérico", restaurantId: 1 },
      { id: 3, name: "Produto Genérico", restaurantId: 1 },
      { id: 4, name: "Produto Genérico", restaurantId: 1 },
      { id: 5, name: "Produto Genérico", restaurantId: 1 },
      { id: 6, name: "Produto Genérico", restaurantId: 1 },
      { id: 7, name: "Produto Genérico", restaurantId: 1 },
      { id: 8, name: "Produto Genérico", restaurantId: 1 },
      { id: 9, name: "Produto Genérico", restaurantId: 1 },
    ]);
  }, []);

  const add = (id) => {
    const product = products.find((x) => x.id == id);
    dispatch(addItem(product));
  };

  return (
    <>
      <Header />
      <Content>
        <h2>{restaurant.name}</h2>
        <h3>{restaurant.type}</h3>
        <h1>Cardápio</h1>

        <div className="cards">
          {products.map((x) => (
            <Card>
              <strong>{x.name}</strong>
              <Button>
                <button onClick={add.bind(this, x.id)}>Adicionar</button>
              </Button>
            </Card>
          ))}
        </div>
      </Content>
    </>
  );
}
export default Restaurant;
