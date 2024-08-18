import React, {useEffect, useState} from 'react';
import Layout from '../../components/Layout/Layout';
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import {getMenu} from "../../services/menuService";
import Button from "@mui/material/Button";
import {ButtonGroup} from "@mui/material";
import './MenuPage.css';


function MenuPage() {
    const [menu, setMenu] = useState([]);

    useEffect(() => {
        fetchMenu();
    }, []);

    const fetchMenu = async () => {
        try {
            const response = await getMenu();
            setMenu(response.data);
        } catch (error) {
            console.error('Błąd podczas pobierania menu:', error);
        }
    };
    const handleMenuClick = (menuId) => {
        localStorage.setItem('selectedMenu', menuId);
    };

    return (
        <Layout>
            <Container>
                <Typography variant="h4" gutterBottom>
                    Menus
                </Typography>
                <ButtonGroup className="menuChoiceButton" variant="text">
                    {menu.map(item => (
                        <Button onClick={() => handleMenuClick(item.id)} key={item.id}>
                            {item.name}
                        </Button>
                    ))}
                </ButtonGroup>
            </Container>
        </Layout>
    );
}

export default MenuPage;
