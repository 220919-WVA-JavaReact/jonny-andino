export interface HyperLink {
    name: string,
    url: string
}

export interface Fact {
    id: number,
    fact: string,
    isTrue: boolean,
}

export interface Game {
    name: string,
    images: string[],
    description: string
}