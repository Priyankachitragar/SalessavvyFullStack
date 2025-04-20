import React from "react";
import { Routes, Route } from "react-router-dom";
import Login from "./Login";
import RegistrationPage from "./RegistrationPage";
// import CustomerHomePage from "./CustomerHomePage";
// import CartPage from "./CartPage";
// import OrderPage from "./OrderPage";
// import AdminLogin from "./AdminLogin"; 
// import AdminDashboard from "./AdminDashboard";

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/register" element={<RegistrationPage />} />
      {/* <Route path="/customerhome" element={<CustomerHomePage />} />
      <Route path="/UserCartPage" element={<CartPage />} />
      <Route path="/orders" element={<OrderPage />} />
      <Route path="/admin" element={<AdminLogin />} />
      <Route path="/admindashboard" element={<AdminDashboard />} /> */}
    </Routes>
  );
};

export default AppRoutes;