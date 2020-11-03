import { Header, Slogan, Jumbotron, Content, Card } from "../styles";

import { MdGpsFixed } from "react-icons/md";
import logo from "../assets/doofi.png";

function Home() {
  return (
    <>
      <Header>
        <div id="logo">
          <img id="logo" src={logo} alt="Doofi" />
        </div>
        <nav>
          <a href="#">Cadastre seu restaurante</a>
          <button>Entrar</button>
        </nav>
        <div id="plate-two"></div>
        <Slogan>
          <div id="slogan">
            <strong>Delivery de comida nunca foi tão fácil</strong>
            <span>Descubra restaurantes perto de você</span>
            <button>
              <MdGpsFixed size={30} color="#fff" />
              Buscar restaurantes
            </button>
          </div>
        </Slogan>
      </Header>
      <Content>
        <Jumbotron>
          <div>
            <strong>A sua fome de crescer tá no Doofi</strong>
            <span>Cadastre seu restaurante e cresça até 50%* no mês.</span>
            <button>Cadastre seu restaurante</button>
          </div>
          <img src={""} alt="asd"></img>
        </Jumbotron>
        <div className="cards">
          <Card>
            <img src={""} alt="entregaGratis" />
            <strong> grátis</strong>
            <span>Almoço bom com entrega grátis</span>
          </Card>
          <Card>
            <img src={""} alt="metadePreco" />
            <strong>Até a metade do preço</strong>
            <span>As melhores promoções para você</span>
          </Card>
          <Card>
            <img src={""} alt="famosos" />
            <strong>Restaurantes famosos</strong>
            <span>Todo mundo conhece e gosta</span>
          </Card>
        </div>
      </Content>
    </>
  );
}
export default Home;
