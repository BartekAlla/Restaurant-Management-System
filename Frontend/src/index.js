import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CssBaseline from '@mui/material/CssBaseline';
import App from './App';
import MenuPage from './pages/MenuPage';
import './index.css';

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
    <React.StrictMode>
        <CssBaseline />
        <Router>
            <Routes>
                <Route path="/" element={<App />} />
                <Route path="/menu" element={<MenuPage />} />
            </Routes>
        </Router>
    </React.StrictMode>
);
