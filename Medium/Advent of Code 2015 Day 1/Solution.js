const fs = require('fs');
const filePath = './input.txt';


const getFloorLast = (filePath) => {
    try {
        const fd = fs.openSync(filePath, 'r');
        const buffer = Buffer.alloc(1);
        let count = 0;
        let index = 0;

        while (true) {
            const bytesRead = fs.readSync(fd, buffer, 0, 1, null);
            if (bytesRead === 0) {
                fs.closeSync(fd);
                return count;
            }
            const char = buffer.toString('utf-8', 0, bytesRead);
            if (char === '(') {
                count++;
            } else {
                count--;
            }
            index++;
        }
    } catch (err) {
        console.error("Error:", err);
        return null;
    }
};


console.log(getFloor(filePath));
