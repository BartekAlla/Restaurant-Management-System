import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CssBaseline from '@mui/material/CssBaseline';
import MenuPage from './pages/MenuPage';
import './index.css';
import OurStoryPage from "./pages/OurStoryPage";
import HomePage from "./pages/HomePage";
import ReservationPage from "./pages/ReservationPage";

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
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
    </React.StrictMode>
);
