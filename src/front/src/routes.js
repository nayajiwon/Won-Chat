import Dashboard from "views/Dashboard.js";
import Notifications from "views/Notifications.js";
import Icons from "views/Icons.js";
import Typography from "views/Typography.js";
import TableList from "views/Tables.js";
import Maps from "views/Map.js";
import UserPage from "views/User.js";
import Login from "views/Login.js";
//<<<<<<< chatting_server
import SignUp from "views/SignUp";
import Chatting from "./components/Chatting/Chatting.js"
import Mainboard from "views/Mainboard.js";
import ChatList from "views/ChatList.js";
var admin_routes = [
  {
    path: "/main",
    name: "Main",
    icon: "nc-icon nc-app",
    component: Mainboard,
    layout: "/admin"
  },
 
  {
    path: "/login",
    name: "Login",
    icon: "nc-icon nc-single-02",
    component: Login,
    layout: "/admin"
  },
  {
    path: "/icons",
    name: "Icons",
    icon: "nc-icon nc-diamond",
    component: Icons,
    layout: "/admin",
  },
  
  {
    path: "/notifications",
    name: "Notifications",
    icon: "nc-icon nc-caps-small",
    component: Notifications,
    layout: "/admin",
  },
  {
    path: "/chatting",
    name: "Chatting",
    icon: "nc-icon nc-bell-55",
    component: Chatting,
    layout: "/admin",
  }

];
var user_routes = [
  {
    path: "/main",
    name: "Main",
    icon: "nc-icon nc-app",
    component: Mainboard,
    layout: "/user"
  },
  {
    path: "/maps",
    name: "Maps",
    icon: "nc-icon nc-world-2",
    component: Maps,
    layout: "/user"
  },{
    path: "/user-page",
    name: "User Profile",
    icon: "nc-icon nc-single-02",
    component: UserPage,
    layout: "/user",
  },
  {
    path: "/chatList",
    name: "Chat List",
    icon: "nc-icon nc-chat-33",
    component: ChatList,
    layout: "/user"
  },
  {
    path: "/tables",
    name: "Table List",
    icon: "nc-icon nc-tile-56",
    component: TableList,
    layout: "/user",
  },
  {
    path: "/typography",
    name: "Typography",
    icon: "nc-icon nc-caps-small",
    component: Typography,
    layout: "/admin",
  }
  
];

export default [admin_routes, user_routes];
