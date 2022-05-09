function showShed() {
    if (!(document.getElementById('cpshed').checked)) {
        document.getElementById('cpshedlengthdiv').style.display="none";
        document.getElementById('cpshedwidthdiv').style.display="none";
    }
    else {
        document.getElementById('cpshedlengthdiv').style.display="block";
        document.getElementById('cpshedwidthdiv').style.display="block";
    }
}