let balance = 2000;

function updateBalanceDisplay() {
    document.getElementById('balance').innerText = balance.toFixed(2);
}

function deposit() {
    const amount = parseFloat(document.getElementById('amount').value);
    if (!isNaN(amount) && amount > 0) {
        balance += amount;
        updateBalanceDisplay();
        document.getElementById('amount').value = '';
    } else {
        alert('Please enter a valid amount');
    }
}

function withdraw() {
    
    const amount = parseFloat(document.getElementById('amount').value);
    if (!isNaN(amount) && amount > 0) {
        if (amount <= balance) {
            balance -= amount;
            updateBalanceDisplay();
            document.getElementById('amount').value = '';
        } else {
            alert('Insufficient balance');
        }
    } else {
        alert('Please enter a valid amount');
    }
}

document.addEventListener('DOMContentLoaded', updateBalanceDisplay);
