import React, {useEffect, useState} from 'react';
import Layout from '../components/Layout';
import Container from '@mui/material/Container';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import Typography from '@mui/material/Typography';
import {getMenu} from "../services/menuService";


function MenuPage() {
    const [menu, setMenu] = useState([]);

    useEffect(() => {
        fetchMenu();
    }, []);

    const fetchMenu = async () => {
        try {
            // Pobranie danych menu
            const response = await getMenu();
            setMenu(response.data);
        } catch (error) {
            console.error('Błąd podczas pobierania menu:', error);
        }
    };

    return (
        <Layout>
            <Container>
                <Typography variant="h4" gutterBottom>
                    Menu
                </Typography>
                <List>
                    {menu.map(item => (
                        <ListItem key={item.id}>
                            <ListItemText primary={item.name}/>
                        </ListItem>
                    ))}
                </List>
            </Container>
        </Layout>
    );
}

export default MenuPage;
