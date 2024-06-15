import React from 'react';
import Box from '@mui/material/Box';

 //TODO - make this shape a wavy rectangle, add color to it and add background color


const Shape = ({ children }) => {
    return (
        <Box
            sx={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                height: '100vh',
                backgroundColor: '#f5f5f5', // Kolor tła
                backgroundImage: 'url("/paper-texture.jpg")', // Obraz tła
                backgroundSize: 'cover',
                backgroundRepeat: 'no-repeat',
                backgroundPosition: 'center',
            }}
        >
            <Box
                sx={{
                    width: '300px', // Szerokość kształtu
                    height: '300px', // Wysokość kształtu
                    backgroundColor: 'rgba(255, 255, 255, 0.8)', // Kolor tła kształtu
                    borderRadius: '50%', // Zaokrąglenie kształtu (tu: koło)
                    display: 'flex',
                    flexDirection: 'column',
                    justifyContent: 'center',
                    alignItems: 'center',
                    textAlign: 'center',
                    padding: '20px',
                }}
            >
                {children}
            </Box>
        </Box>
    );
};

export default Shape;
