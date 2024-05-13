export interface Element {
    number?: number;
    name?: string;
    symbol?: string;
    atomic_mass?: number;
    image?: Image;
    bgcolor?: string;
    phase?: string;
    xpos: number;
    ypos: number
}

export default interface Elements {
    elements: Element[];
}

export interface Image {
    url: string;
}