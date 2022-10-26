import React from "react";
import { ReactNode } from "react";

export default class Footer extends React.Component {
    render(): ReactNode {
        return (
            <footer className="text-sm text-center p-4 m-2 border rounded-md">
                <span>2022 - Jonny Andino</span>
            </footer>
        )
    }
}
