export type RecipeComponentType ={
    id: string;
    raw_text: string;
};
export type RecipeSectionType ={
    components: Array<RecipeComponentType>;
}

export type RecipeType = {
    id: number;
    name: string;
    description: string;
    thumbnail_url: string;
    sections: Array<RecipeSectionType>;
};