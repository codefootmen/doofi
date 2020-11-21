import { Content, Card } from "../styles";
import { useState } from "react";
import { Link } from "react-router-dom";
import Header from "../components/Header";

function Home() {
  const [user, setUser] = useState({ name: "Batata" });
  const [restaurants, setRestaurants] = useState([
    { name: "Restaurante Genérico #1", id: 1 },
    { name: "Restaurante Genérico #2", id: 2 },
    { name: "Restaurante Genérico #3", id: 3 },
    { name: "Restaurante Genérico #4", id: 4 },
  ]);

  return (
    <>
      <Header />
      <Content>
        <div className="cards">
          {restaurants.map((x) => {
            return (
              <Link
                to={`/restaurant/${x.id}`}
                style={{ textDecoration: "none" }}
              >
                <Card>
                  <strong>{x.name}</strong>
                  <span>Almoço bom com entrega grátis</span>
                </Card>
              </Link>
            );
          })}
        </div>
      </Content>
    </>
  );
}
export default Home;
