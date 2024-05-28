export default function canvasBg(){
	var w = window.innerWidth;
	var h = window.innerHeight;
	var ctx = document.getElementById('canvas');
	
	window.addEventListener('load', resize);
	window.addEventListener('resize', resize, false);
	
	function resize() {
		ctx.width = w = window.innerWidth;
		ctx.height = h = window.innerHeight;
	}
	
	resize();
	
	let ctxfr = ctx.getContext('2d');
	
	// min and max radius, radius threshold and percentage of filled circles
	var radMin = 5,
		radMax = 125,
		filledCircle = 60, //percentage of filled circles
		concentricCircle = 30, //percentage of concentric circles
		radThreshold = 25; //IFF special, over this radius concentric, otherwise filled
	
	//min and max speed to move
	var speedMin = 0.3,
		speedMax = 2.5;
	
	//max reachable opacity for every circle and blur effect
	var maxOpacity = 0.6;
	
	//default palette choice
	var colors = ['52,168,83', '117,95,147', '199,108,23', '194,62,55', '0,172,212', '120,120,120'],
		bgColors = ['52,168,83', '117,95,147', '199,108,23', '194,62,55', '0,172,212', '120,120,120'],
		circleBorder = 10,
		backgroundLine = bgColors[0];
	var backgroundMlt = 0.85;
	
	//min distance for links
	var linkDist = Math.min(canvas.width, canvas.height) / 2.4,
		lineBorder = 2.5;
	
	//most importantly: number of overall circles and arrays containing them
	var maxCircles = 12,
		points = [],
		pointsBack = [];
	
	//populating the screen
	for (var i = 0; i < maxCircles * 2; i++) points.push(new Circle());
	for (var i = 0; i < maxCircles; i++) pointsBack.push(new Circle(true));
	
	//experimental vars
	var circleExp = 1,
		circleExpMax = 1.003,
		circleExpMin = 0.997,
		circleExpSp = 0.00004,
		circlePulse = false;
	
	//circle class
	function Circle(background) {
		//if background, it has different rules
		this.background = (background || false);
		this.x = randRange(-canvas.width / 2, canvas.width / 2);
		this.y = randRange(-canvas.height / 2, canvas.height / 2);
		this.radius = background ? hyperRange(radMin, radMax) * backgroundMlt : hyperRange(radMin, radMax);
		this.filled = this.radius < radThreshold ? (randint(0, 100) > filledCircle ? false : 'full') : (randint(0, 100) >
			concentricCircle ? false : 'concentric');
		this.color = background ? bgColors[randint(0, bgColors.length - 1)] : colors[randint(0, colors.length - 1)];
		this.borderColor = background ? bgColors[randint(0, bgColors.length - 1)] : colors[randint(0, colors.length - 1)];
		this.opacity = 0.05;
		this.speed = (background ? randRange(speedMin, speedMax) / backgroundMlt : randRange(speedMin, speedMax)); // * (radMin / this.radius);
		this.speedAngle = Math.random() * 2 * Math.PI;
		this.speedx = Math.cos(this.speedAngle) * this.speed;
		this.speedy = Math.sin(this.speedAngle) * this.speed;
		var spacex = Math.abs((this.x - (this.speedx < 0 ? -1 : 1) * (canvas.width / 2 + this.radius)) / this.speedx),
			spacey = Math.abs((this.y - (this.speedy < 0 ? -1 : 1) * (canvas.height / 2 + this.radius)) / this.speedy);
		this.ttl = Math.min(spacex, spacey);
	};
	
	Circle.prototype.init = function() {
		Circle.call(this, this.background);
	}
	
	//support functions
	//generate random int a<=x<=b
	function randint(a, b) {
		return Math.floor(Math.random() * (b - a + 1) + a);
	}
	//generate random float
	function randRange(a, b) {
		return Math.random() * (b - a) + a;
	}
	//generate random float more likely to be close to a
	function hyperRange(a, b) {
		return Math.random() * Math.random() * Math.random() * (b - a) + a;
	}
	
	//rendering function
	function drawCircle(ctx, circle) {
		//circle.radius *= circleExp;
		var radius = circle.background ? circle.radius *= circleExp : circle.radius /= circleExp;
		ctx.beginPath();
		ctx.arc(circle.x, circle.y, radius * circleExp, 0, 2 * Math.PI, false);
		ctx.lineWidth = Math.max(1, circleBorder * (radMin - circle.radius) / (radMin - radMax));
		ctx.strokeStyle = ['rgba(', circle.borderColor, ',', circle.opacity, ')'].join('');
		if (circle.filled == 'full') {
			ctx.fillStyle = ['rgba(', circle.borderColor, ',', circle.background ? circle.opacity * 0.8 : circle.opacity, ')']
				.join('');
			ctx.fill();
			ctx.lineWidth = 0;
			ctx.strokeStyle = ['rgba(', circle.borderColor, ',', 0, ')'].join('');
		}
		ctx.stroke();
		if (circle.filled == 'concentric') {
			ctx.beginPath();
			ctx.arc(circle.x, circle.y, radius / 2, 0, 2 * Math.PI, false);
			ctx.lineWidth = Math.max(1, circleBorder * (radMin - circle.radius) / (radMin - radMax));
			ctx.strokeStyle = ['rgba(', circle.color, ',', circle.opacity, ')'].join('');
			ctx.stroke();
		}
		circle.x += circle.speedx;
		circle.y += circle.speedy;
		if (circle.opacity < (circle.background ? maxOpacity : 1)) circle.opacity += 0.01;
		circle.ttl--;
	}
	
	//initializing function
	function init() {
		window.requestAnimationFrame(draw);
	}
	
	//rendering function
	function draw() {
	
		if (circlePulse) {
			if (circleExp < circleExpMin || circleExp > circleExpMax) circleExpSp *= -1;
			circleExp += circleExpSp;
		}
	
		ctxfr.globalCompositeOperation = 'destination-over';
		ctxfr.clearRect(0, 0, canvas.width, canvas.height); // clear canvas
	
		ctxfr.save();
		ctxfr.translate(canvas.width / 2, canvas.height / 2);
	
		//function to render each single circle, its connections and to manage its out of boundaries replacement
		function renderPoints(ctx, arr) {
			for (var i = 0; i < arr.length; i++) {
				var circle = arr[i];
				//checking if out of boundaries
				if (circle.ttl < 0) {}
				var xEscape = canvas.width / 2 + circle.radius,
					yEscape = canvas.height / 2 + circle.radius;
				if (circle.ttl < -20) arr[i].init(arr[i].background);
				//if (Math.abs(circle.y) > yEscape || Math.abs(circle.x) > xEscape) arr[i].init(arr[i].background);
				drawCircle(ctx, circle);
			}
			for (var i = 0; i < arr.length - 1; i++) {
				for (var j = i + 1; j < arr.length; j++) {
					var deltax = arr[i].x - arr[j].x;
					var deltay = arr[i].y - arr[j].y;
					var dist = Math.pow(Math.pow(deltax, 2) + Math.pow(deltay, 2), 0.5);
					//if the circles are overlapping, no laser connecting them
					if (dist <= arr[i].radius + arr[j].radius) continue;
					//otherwise we connect them only if the dist is < linkDist
					if (dist < linkDist) {
						var xi = (arr[i].x < arr[j].x ? 1 : -1) * Math.abs(arr[i].radius * deltax / dist);
						var yi = (arr[i].y < arr[j].y ? 1 : -1) * Math.abs(arr[i].radius * deltay / dist);
						var xj = (arr[i].x < arr[j].x ? -1 : 1) * Math.abs(arr[j].radius * deltax / dist);
						var yj = (arr[i].y < arr[j].y ? -1 : 1) * Math.abs(arr[j].radius * deltay / dist);
						ctx.beginPath();
						ctx.moveTo(arr[i].x + xi, arr[i].y + yi);
						ctx.lineTo(arr[j].x + xj, arr[j].y + yj);
						var samecolor = arr[i].color == arr[j].color;
						ctx.strokeStyle = ["rgba(", arr[i].borderColor, ",", Math.min(arr[i].opacity, arr[j].opacity) * ((linkDist -
							dist) / linkDist), ")"].join("");
						ctx.lineWidth = (arr[i].background ? lineBorder * backgroundMlt : lineBorder) * ((linkDist - dist) / linkDist); //*((linkDist-dist)/linkDist);
						ctx.stroke();
					}
				}
			}
		}
	
		renderPoints(ctxfr, points);
		ctxfr.restore();
	
		window.requestAnimationFrame(draw);
	}
	
	init();
}