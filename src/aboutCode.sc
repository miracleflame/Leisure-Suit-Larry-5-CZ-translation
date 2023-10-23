;;; Sierra Script 1.0 - (do not remove this comment)
(script# 15)
(include sci.sh)
(use Main)
(use DCIcon)
(use Cycle)
(use Obj)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)
	
	(method (doit &tmp [temp0 200])
		(Load rsVIEW 993)
		(proc0_14
			15
			0
			33
			global23
			30
			1
			70
			222
			80
			{Sierra Presents}
		)
		(cycleIcon loop: 2)
		(proc0_14
			15
			1
			33
			global23
			30
			1
			82
			cycleIcon
			70
			180
			80
			{The Bosses}
		)
		(cycleIcon loop: 3)
		(proc0_14
			15
			2
			33
			global23
			30
			1
			82
			cycleIcon
			70
			200
			80
			{The Workers}
		)
		(cycleIcon loop: 1)
		(proc0_14
			15
			3
			33
			global23
			30
			1
			82
			cycleIcon
			70
			200
			80
			{The Boys in the Band}
		)
		(cycleIcon loop: 0)
		(Format @temp0 15 4 global27 global181)
		(proc0_14
			@temp0
			33
			global23
			30
			1
			82
			cycleIcon
			70
			222
			80
			{The Hackers}
		)
		(Format @temp0 15 5 global182 global112)
		(proc0_14
			@temp0
			33
			global23
			30
			1
			70
			222
			80
			{A Paid Commercial Announcement}
		)
		(proc0_14
			15
			6
			33
			global23
			30
			1
			70
			266
			80
			{More Laffer Laughs}
		)
		(proc0_14
			15
			7
			33
			global23
			30
			1
			70
			234
			80
			{Discontinued Products}
		)
	)
)

(instance cycleIcon of DCIcon
	(properties
		view 993
		cycleSpeed 15
	)
	
	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)
