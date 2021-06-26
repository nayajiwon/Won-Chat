import React, { useState } from "react";
import { Route, Switch, useLocation } from "react-router-dom";

import Footer from "../components/Footer/Footer.js";
import Sidebar from "../components/Sidebar/Sidebar.js";
import FixedPlugin from "components/FixedPlugin/FixedPlugin.js";

import routes from "routes.js";
import Login from "../views/Login";

function Dashboard(props) {
  const [backgroundColor, setBackgroundColor] = React.useState("black");
  const [activeColor, setActiveColor] = React.useState("info");
  const [route, setRoute] = useState(routes[0]);
  const mainPanel = React.useRef();
  const location = useLocation();

  React.useEffect(() => {
    mainPanel.current.scrollTop = 0;
    document.scrollingElement.scrollTop = 0;
  }, [location]);
  const handleActiveClick = (color) => {
    setActiveColor(color);
  };
  const handleBgClick = (color) => {
    setBackgroundColor(color);
  };
  const  makeUserPage = (props)=>{
    if(props.path === "user"){
      setRoute(routes[1]);
    }
    else{
      setRoute(routes[0]);
    }
  }
  return (
    <div className="wrapper">
      <Sidebar
        {...props}
        routes={route}
        bgColor={backgroundColor}
        activeColor={activeColor}
      />
      <div className="main-panel" ref={mainPanel}>
      
        <Switch>
          {route.map((prop, key) => {
            /* 왜 undefined 뜨는지 이해 못했음. undefined되면 admin으로 돌아오도록 함 */
            if(prop.layout === undefined){
              prop.layout = "/admin";
            }
            return (
              <Route 
                path={prop.layout + prop.path}
                component={prop.component}
                key={key}
              />
            );
          })}
        </Switch>
        <Footer fluid />
      </div>
      <FixedPlugin
        bgColor={backgroundColor}
        activeColor={activeColor}
        handleActiveClick={handleActiveClick}
        handleBgClick={handleBgClick}
      />
    </div>
  );
}

export default Dashboard;
