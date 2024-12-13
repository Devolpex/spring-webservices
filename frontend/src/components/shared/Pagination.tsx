import React, { useState } from "react";
import { Button, IconButton } from "@material-tailwind/react";

interface PaginationProps {
  total: number;
  initialPage?: number;
  onPageChange: (page: number) => void;
}

const Pagination: React.FC<PaginationProps> = ({ total, initialPage = 1, onPageChange }) => {
  const [currentPage, setCurrentPage] = useState(initialPage);
  const totalPages = Math.ceil(total / 10);

  const handlePageChange = (page: number) => {
    setCurrentPage(page);
    onPageChange(page);
  };

  const handlePrevious = () => {
    if (currentPage > 1) {
      handlePageChange(currentPage - 1);
    }
  };

  const handleNext = () => {
    if (currentPage < totalPages) {
      handlePageChange(currentPage + 1);
    }
  };

  const renderPageNumbers = () => {
    const pageNumbers = [];
    const startPage = Math.max(1, currentPage - 4);
    const endPage = Math.min(totalPages, startPage + 9);

    for (let i = startPage; i <= endPage; i++) {
      pageNumbers.push(
        <IconButton
          key={i}
          variant={currentPage === i ? "outlined" : "text"}
          size="sm"
          onClick={() => handlePageChange(i)}
        >
          {i}
        </IconButton>
      );
    }

    return pageNumbers;
  };

  return (
    <div className="flex items-center justify-between border-t border-blue-gray-50 p-4">
      <Button
        variant="outlined"
        size="sm"
        onClick={handlePrevious}
      >
        Previous
      </Button>
      <div className="flex items-center gap-2">
        {renderPageNumbers()}
      </div>
      <Button
        variant="outlined"
        size="sm"
        onClick={handleNext}
      >
        Next
      </Button>
    </div>
  );
};

export default Pagination;