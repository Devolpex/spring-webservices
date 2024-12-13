import { Outlet } from "react-router-dom";
import { ReservationProvider } from "../providers/ReservationProvider";
import { DefaultSidebar } from "../components/shared/Sidebar";
import { NavbarDefault } from "../components/shared/Navbar";

export function LayoutGraphQL() {
  return (
    <div className="flex min-h-screen bg-gray-100">
      <DefaultSidebar />
      <div className="flex-1">
        <NavbarDefault />
        <main className="px-16 mt-8"> 
          <ReservationProvider>
            <Outlet />
          </ReservationProvider>
        </main>
      </div>
    </div>
  );
}