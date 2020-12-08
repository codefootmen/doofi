import { Content, Table, Button } from "../styles";
import { useEffect, useState, React } from "react";
import Header from "../components/Header";
import { api } from "../services/api";

function Orders() {
  //   const products = useSelector((state) => state.products);
  //   console.log(products);

  const [orders, setOrders] = useState([]);

  const transformRequest = (jsonData = {}) =>
    Object.entries(jsonData)
      .map((x) => `${encodeURIComponent(x[0])}=${encodeURIComponent(x[1])}`)
      .join("&");

  useEffect(async () => {
    const get = async () => {
      let o = await api().get(`/action/GetAllOrdersAction/`);
      return o;
    };
    let response = await get();
    setOrders(response.data);
  }, []);

  const accept = (i, id) => {
    let obj = orders.filter((x) => {
      return x.value.orderId == i;
    });

    api()
      .post(
        `/action/ChangeStateToAcceptedAction/`,
        transformRequest({
          value: JSON.stringify(obj[0].value),
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
  };

  const cancel = (i, id) => {
    let obj = orders.filter((x) => {
      return x.value.orderId == i;
    });
    api()
      .post(
        `/action/ChangeStateToCancelledStateAction/`,
        transformRequest({
          value: JSON.stringify(obj[0].value),
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
  };

  const send = async (i, id) => {
    let obj = orders.filter((x) => {
      return x.value.orderId == i;
    });

    api()
      .post(
        `/action/ChangeStateToSentStateAction/`,
        transformRequest({
          value: JSON.stringify(obj[0].value),
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
  };

  const complete = (i, id) => {
    let obj = orders.filter((x) => {
      return x.value.orderId == i;
    });

    api()
      .post(
        `/action/ChangeStateToDeliveriedStateAction/`,
        transformRequest({
          value: JSON.stringify(obj[0].value),
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
  };

  return (
    <>
      <Header />
      <Content>
        <Table>
          <tr>
            <th>Order ID</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
          {orders.map((x) => (
            <tr>
              <td>{x.value.orderId}</td>
              <td>{x.value.currentStatus}</td>
              <td>
                <Button>
                  <button onClick={accept.bind(this, x.value.orderId)}>
                    Aceitar
                  </button>
                </Button>
              </td>
              <td>
                <Button>
                  <button onClick={send.bind(this, x.value.orderId)}>
                    Enviar
                  </button>
                </Button>
              </td>
              <td>
                <Button>
                  <button onClick={complete.bind(this, x.value.orderId)}>
                    Finalizar Pedido
                  </button>
                </Button>
              </td>
              <td>
                <Button>
                  <button onClick={cancel.bind(this, x.value.orderId)}>
                    Cancelar
                  </button>
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
