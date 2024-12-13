// src/components/TableHeader.tsx
import React from "react";
import { Typography } from "@material-tailwind/react";

interface TableHeaderProps {
  headers: string[];
}

const TableHeader: React.FC<TableHeaderProps> = ({ headers }) => {
  return (
    <thead>
      <tr>
        {headers.map((head) => (
          <th
            key={head}
            className="border-y border-blue-gray-100 bg-blue-gray-50/50 p-4"
          >
            <Typography
              variant="small"
              color="blue-gray"
              className="font-normal leading-none opacity-70"
              placeholder={undefined}
              onPointerEnterCapture={undefined}
              onPointerLeaveCapture={undefined}
            >
              {head}
            </Typography>
          </th>
        ))}
      </tr>
    </thead>
  );
};

export default TableHeader;
