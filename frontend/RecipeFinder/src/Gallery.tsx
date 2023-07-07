import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Recipe from './Recipe.tsx';
import {RecipeType} from "./Types.ts";


function Gallery() {
    const [recipes, setRecipes] = useState<RecipeType[]>([]);
    const [query, setQuery] = useState('');
    const [loading, setLoading] = useState(false);

    const handleQueryChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setQuery(e.target.value);
    };

    const handleSubmitSearch = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        getRecipes(query);
    };

    useEffect(() => {
        getRecipes('salad lettuce');
    }, []);

    const getRecipes = async (query: string) => {
        try {
            setLoading(true)
            const response = await axios.get('http://localhost:8080/api/recipes/search', {
                params: {
                    query: query,
                },
            });
            setRecipes(response.data.results);
            setLoading(false)
        } catch (error) {
            setLoading(false)
            console.log(error);
        }
    };

    return (
        <>
            {/*<div className="container">*/}
            {/*    <div className="row">*/}
            {/*        <img src="Foodi.jpg" className="img-fluid" alt="..."/>*/}
            {/*        <span className="overlay-text">Tasty Finder</span>*/}

            {/*    </div>*/}
            {/*</div>*/}
            <div className="Gallery">
                <h1>Tasty Finder</h1>
                <form className="search-form" onSubmit={handleSubmitSearch}>
                    <div className="input-group mb-3">
                        <input
                            type="text"
                            className="form-control search-bar"
                            placeholder="Search here"
                            aria-label="Search recipe"
                            aria-describedby="button-addon2"
                            onChange={handleQueryChange}
                        />
                        <button className="btn btn-outline-secondary search-button" type="submit" id="button-addon2">
                            Search
                        </button>
                    </div>
                </form>
                <div className="container">
                    {!loading ? (
                        <div className="row">
                            {recipes.length ? (
                                recipes.map((recipe) => (
                                    <Recipe key={recipe.id} recipe={recipe}/>
                                ))
                            ) : (
                                <h1>No Result</h1>
                            )}
                        </div>
                    ) : (
                        <h1><img src="loading.gif"/></h1>
                    )}
                </div>
            </div>
        </>
    );
}

export default Gallery;
