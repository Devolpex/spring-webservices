// src/components/ReservationsTable.tsx
import {
  ArrowDownTrayIcon,
  MagnifyingGlassIcon,
} from "@heroicons/react/24/outline";
import {
  Card,
  CardHeader,
  Typography,
  Button,
  CardBody,
  Input,
  CardFooter,
} from "@material-tailwind/react";
import TableHeader from "./table/TableHeader";
import TableBody from "./table/TableBody";
import Pagination from "./shared/Pagination";
import { useReservationContext } from "../providers/ReservationProvider";

interface ReservationsTableProps {
  headers: string[];
  rows: Reservation[];
  total: number;
  initialPage?: number;
}

export function ReservationsTable({
  headers,
  rows,
  total,
  initialPage,
}: ReservationsTableProps) {
  const { fetchParams, setFetchParams } = useReservationContext();
  return (
    <Card
      className="h-full w-full"
      placeholder={undefined}
      onPointerEnterCapture={undefined}
      onPointerLeaveCapture={undefined}
    >
      <CardHeader
        floated={false}
        shadow={false}
        className="rounded-none"
        placeholder={undefined}
        onPointerEnterCapture={undefined}
        onPointerLeaveCapture={undefined}
      >
        <div className="mb-4 flex flex-col justify-between gap-8 md:flex-row md:items-center">
          <div>
            <Typography
              variant="h5"
              color="blue-gray"
              placeholder={undefined}
              onPointerEnterCapture={undefined}
              onPointerLeaveCapture={undefined}
            >
              Recent Reservations
            </Typography>
            <Typography
              color="gray"
              className="mt-1 font-normal"
              placeholder={undefined}
              onPointerEnterCapture={undefined}
              onPointerLeaveCapture={undefined}
            >
              These are details about the last reservations
            </Typography>
          </div>
          <div className="flex w-full shrink-0 gap-2 md:w-max">
            <div className="w-full md:w-72">
              <Input
                label="Search"
                icon={<MagnifyingGlassIcon className="h-5 w-5" />}
                onPointerEnterCapture={undefined}
                onPointerLeaveCapture={undefined}
                crossOrigin={undefined}
              />
            </div>
            <Button
              className="flex items-center gap-3"
              size="sm"
              placeholder={undefined}
              onPointerEnterCapture={undefined}
              onPointerLeaveCapture={undefined}
            >
              <ArrowDownTrayIcon strokeWidth={2} className="h-4 w-4" /> Download
            </Button>
          </div>
        </div>
      </CardHeader>
      <CardBody
        className="px-0"
        placeholder={undefined}
        onPointerEnterCapture={undefined}
        onPointerLeaveCapture={undefined}
      >
        <table className="w-full min-w-max table-auto text-left">
          <TableHeader headers={headers} />
          <TableBody rows={rows} />
        </table>
      </CardBody>
      <CardFooter
        placeholder={undefined}
        onPointerEnterCapture={undefined}
        onPointerLeaveCapture={undefined}
      >
        <Pagination
          total={total}
          initialPage={initialPage}
          onPageChange={(page) => setFetchParams({ ...fetchParams, page })}
        />
      </CardFooter>
    </Card>
  );
}

export interface Reservation {
  id: string;
  client: Client;
  chambre: Chambre;
  dateDebut: string;
  dateFin: string;
  preferences: string;
}

export interface Client {
  id: string;
  nom: string;
  prenom: string;
  email: string;
  telephone: string;
}

export interface Chambre {
  id: string;
  type: string;
  prix: number;
  disponible: boolean;
}
