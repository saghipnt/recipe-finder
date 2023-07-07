import './App.css';
import {RecipeComponentType, RecipeSectionType, RecipeType} from "./Types.ts";

type RecipePropsType = {
    recipe: RecipeType
}

function Recipe({recipe}: RecipePropsType) {
    return (
        <>
            <div className="col-lg-4 col-md-12 recipe-col">
                <div className="card h-100 text-bg-light mb-3 recipe">
                    <img src={recipe.thumbnail_url} className="card-img-top" alt="..."/>
                    <div className="card-body panel-body">
                        <h5 className="card-title">{recipe.name}</h5>
                        <ul className="list-group">
                            {recipe.sections && recipe.sections.map((section: RecipeSectionType) => (
                                section.components.map((component: RecipeComponentType) => (
                                    <ol className="list-group-item">{component.raw_text}</ol>
                                ))
                            ))}
                        </ul>
                    </div>
                </div>
            </div>

        </>
    );
}

export default Recipe
