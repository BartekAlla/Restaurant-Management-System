import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CssBaseline from '@mui/material/CssBaseline';
import MenuPage from './pages/MenuPage/MenuPage';
import './index.css';
import OurStoryPage from "./pages/OurStoryPage";
import HomePage from "./pages/HomePage";
import ReservationPage from "./pages/ReservationPage";

ReactDOM.render(
    <React.StrictMode>
        <CssBaseline />
        <Router>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/menus" element={<MenuPage />} />
                <Route path="/story" element={<OurStoryPage />} />
                <Route path="/reservation" element={<ReservationPage />} />
            </Routes>
        </Router>
    </React.StrictMode>,
    document.getElementById('root')  // Pass this directly to ReactDOM.render
);
