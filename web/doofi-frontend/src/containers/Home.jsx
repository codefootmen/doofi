import { Content, Card } from "../styles";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Header from "../components/Header";
import { GetAllBusinesses } from "../model/restaurants.model"

 function Home() {
  const [user, setUser] = useState({ name: "Batata" });
 
  const [restaurants, setRestaurants] = useState([]); 

  useEffect(async()=>{
    GetAllBusinesses().then(x => {
      setRestaurants(x);
    });
  });

  return (
    <>
      <Header />
      <Content>
        <div className="cards">
          { restaurants ? restaurants.map((x) => {
            return (
              <Link key={x.value.businessId}
                to={`/restaurant/${x.value.businessId}`}
                style={{ textDecoration: "none" }}
              >
                <Card>
                  <strong>{x.value.name}</strong>
                  <span>{x.value.neighbourhood} - {x.value.city}</span>
                </Card>
              </Link>
            );
          }) : "" }
        </div>
      </Content>
    </>
  );
}
export default Home;
