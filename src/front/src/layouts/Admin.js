import React, { useState } from "react";
import { Route, Switch, useLocation } from "react-router-dom";

import Footer from "../components/Footer/Footer.js";
import Sidebar from "../components/Sidebar/Sidebar.js";
import FixedPlugin from "components/FixedPlugin/FixedPlugin.js";

import routes from "routes.js";

function Dashboard(props) {
  const [backgroundColor, setBackgroundColor] = React.useState("black");
  const [activeColor, setActiveColor] = React.useState("info");
  const [route, setRoute] = useState(routes[0]);
  const mainPanel = React.useRef();
  const location = useLocation();
  const isLogined = false;
  React.useEffect(() => {
    mainPanel.current.scrollTop = 0;
    document.scrollingElement.scrollTop = 0;
  }, [location]);
  React.useEffect(()=>{
    console.log(props.match.path);
    if(props.match.path === "/user" && isLogined === true){
      setRoute(routes[1]);
    }
    else if(props.match.path === "/user" && isLogined === false){
      window.location.href =  "/admin/main"
       
    }
    else{
      setRoute(routes[0]);
    }
  });
  const handleActiveClick = (color) => {
    setActiveColor(color);
  };
  const handleBgClick = (color) => {
    setBackgroundColor(color);
  };

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
