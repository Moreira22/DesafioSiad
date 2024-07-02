import { UserCircle } from 'lucide-react'
import Image from 'next/image'
import Link from 'next/link'
import React from 'react'


export const Header = () => {
    return (
        <div
            className="bg-white shadow-md w-full p-5 h-[75px] flex justify-between items-center z-20"
            id="header"
        >
            <div className="relative h-[75px] w-[175px] ">
                <Link href="/home">
                    <Image
                        src="/logo.png"
                        alt="Siad Sistemas"
                        fill
                        style={{
                            objectFit: "contain",
                        }}
                    />
                </Link>
            </div>
        </div>
    )
}